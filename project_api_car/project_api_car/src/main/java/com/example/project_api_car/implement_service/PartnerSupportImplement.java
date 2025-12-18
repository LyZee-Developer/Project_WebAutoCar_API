package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.partner_support.PartnerSupportDataModel;
import com.example.project_api_car.data_model.partner_support.PartnerSupportFilterDataModel;
import com.example.project_api_car.dto.PartnerSupportDto;
import com.example.project_api_car.entity.DB_IMAGE;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.helper.PartnerSupportHelper;
import com.example.project_api_car.mapper.PartnerSupportMapper;
import com.example.project_api_car.repository.ImageRepository;
import com.example.project_api_car.repository.PartnerSupportRepository;
import com.example.project_api_car.service.PartnerSupportService;
import com.example.project_api_car.specification.PartnerSupportSpec;
import com.example.project_api_car.util.UploadImageHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PartnerSupportImplement implements  PartnerSupportService {
    private final PartnerSupportRepository  partnerSupportRepository;
    private final ImageRepository  imageRepository;
    @Override
    public List<PartnerSupportDto> List(PartnerSupportFilterDataModel filter){
        var list = partnerSupportRepository.findAll(PartnerSupportSpec.Search(filter.getSearch()).and(PartnerSupportSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getSTATUS().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->{
            var pathImage = "";
            var img = imageRepository.findByRefIdAndType(s.getID(), PartnerSupportHelper.FolderName.PartnerSupport);
            if(img!=null) pathImage = img.getPathImage();
            return PartnerSupportMapper.MaptoDto(s,totalRecord,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  PartnerSupportDto  Create(PartnerSupportDataModel model){
           var image = new DB_IMAGE();
        var mapData = PartnerSupportMapper.MaptoEntity(model);
        var data = partnerSupportRepository.save(mapData);
        var PathImage = "";
        if(model.getUpload()!=null){
            var upload = new UploadImageHandler(PartnerSupportHelper.FolderName.PartnerSupport);
            var dto = upload.Upload(model.getUpload());
            image.setHostImage(dto.getHostName());
            image.setNameImage(dto.getFilename());
            image.setSizeImage(dto.getSize());
            image.setRefId(data.getID());
            image.setType(PartnerSupportHelper.FolderName.PartnerSupport);
            image.setTypeImage(dto.getType());
            image.setPathImage(dto.getPathFilename());
            imageRepository.save(image);
            PathImage=image.getHostImage()+"/"+image.getPathImage();
        }
        var result = PartnerSupportMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public PartnerSupportDto Update(PartnerSupportDataModel model){
        var image = imageRepository.findByRefIdAndType(model.getId(), PartnerSupportHelper.FolderName.PartnerSupport);
        var data = partnerSupportRepository.findById(model.getId()).get();
        var upload = new UploadImageHandler(PartnerSupportHelper.FolderName.PartnerSupport.toLowerCase());
        var PathImage="";
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setSTATUS(model.getStatus());
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        partnerSupportRepository.save(data);
        if(model.getUpload()!=null){
            if(image!=null) {
                upload.DeleteImage(image.getNameImage());
                imageRepository.delete(image);
            }
            var dto = upload.Upload(model.getUpload());
            var newImg = new DB_IMAGE();
            newImg.setHostImage(dto.getHostName());
            newImg.setNameImage(dto.getFilename());
            newImg.setSizeImage(dto.getSize());
            newImg.setRefId(data.getID());
            newImg.setType(PartnerSupportHelper.FolderName.PartnerSupport);
            newImg.setTypeImage(dto.getType());
            newImg.setPathImage(dto.getPathFilename());
            imageRepository.save(newImg);
            PathImage=newImg.getHostImage()+"/"+newImg.getPathImage();
        }
        var result = PartnerSupportMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        partnerSupportRepository.deleteById(Id);
        return true;
    }
    @Override
    public Boolean DeleteImage(Long imageId){
        var upload = new UploadImageHandler(PartnerSupportHelper.FolderName.PartnerSupport.toLowerCase());
        var image = imageRepository.findById(imageId);
        if(!image.isEmpty()){
            upload.DeleteImage(image.get().getNameImage());
            imageRepository.delete(image.get());
            return true;
        }
        return false;
    }
    
}
