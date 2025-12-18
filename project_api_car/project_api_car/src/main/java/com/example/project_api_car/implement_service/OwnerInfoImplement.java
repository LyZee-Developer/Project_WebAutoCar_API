package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.owner_info.OwnerInfoDataModel;
import com.example.project_api_car.data_model.owner_info.OwnerInfoFilterDataModel;
import com.example.project_api_car.dto.OwnerInfoDto;
import com.example.project_api_car.entity.DB_IMAGE;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.helper.OwnerInfoHelper;
import com.example.project_api_car.mapper.OwnerInfoMapper;
import com.example.project_api_car.repository.ImageRepository;
import com.example.project_api_car.repository.OwnerInfoRepository;
import com.example.project_api_car.service.OwnerInfoService;
import com.example.project_api_car.specification.OwnerInfoSpec;
import com.example.project_api_car.util.UploadImageHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OwnerInfoImplement implements  OwnerInfoService {
    private final OwnerInfoRepository  ownerInfoRepository;
    private final ImageRepository  imageRepository;
    @Override
    public List<OwnerInfoDto> List(OwnerInfoFilterDataModel filter){
        // var list = ownerInfoRepository.findAll(OwnerInfoSpec.Search(filter.getSearch()).and(OwnerInfoSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        var list = ownerInfoRepository.findAll(OwnerInfoSpec.Search(filter.getSearch()).and(OwnerInfoSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->{
            var pathImage = "";
            var img = imageRepository.findByRefIdAndType(s.getID(), OwnerInfoHelper.FolderName.Owner);
            if(img!=null) pathImage = img.getHostImage()+"/"+img.getPathImage();
            return OwnerInfoMapper.MaptoDto(s,totalRecord,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  OwnerInfoDto  Create(OwnerInfoDataModel model){
        var image = new DB_IMAGE();
        var mapData = OwnerInfoMapper.MaptoEntity(model);
        var data = ownerInfoRepository.save(mapData);
        var PathImage = "";
        if(model.getUpload()!=null){
            var upload = new UploadImageHandler(OwnerInfoHelper.FolderName.Owner.toLowerCase());
            var dto = upload.Upload(model.getUpload());
            image.setHostImage(dto.getHostName());
            image.setNameImage(dto.getFilename());
            image.setSizeImage(dto.getSize());
            image.setRefId(data.getID());
            image.setType(OwnerInfoHelper.FolderName.Owner);
            image.setTypeImage(dto.getType());
            image.setPathImage(dto.getPathFilename());
            imageRepository.save(image);
            PathImage=image.getHostImage()+"/"+image.getPathImage();
        }
        var result = OwnerInfoMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public OwnerInfoDto Update(OwnerInfoDataModel model){
        var image = imageRepository.findByRefIdAndType(model.getId(), OwnerInfoHelper.FolderName.Owner);
        var upload = new UploadImageHandler(OwnerInfoHelper.FolderName.Owner.toLowerCase());
        var data = ownerInfoRepository.findById(model.getId()).get();
        var PathImage="";
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setSUB_DESCRIPTION(model.getSubDescription());
        data.setSUB_DESCRIPTION_EN(model.getSubDescriptionEnglish());
        data.setDESCRIPTION_EN(model.getDescriptionEnglish());
        data.setPHONE1(model.getPhone1());
        data.setDESCRIPTION(model.getDescription());
        data.setFACEBOOK_URL(model.getFacebookURL());
        data.setIN_URL(model.getInURL());
        data.setINSTAGRAM_URL(model.getInstagramURL());
        data.setTELEGRAM_URL(model.getTelegramURL());
        data.setYOUTUBE_URL(model.getYoutubeURL());
        data.setWORKING_INFO(model.getWorkingInfo());
        ownerInfoRepository.save(data);
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
            newImg.setType(OwnerInfoHelper.FolderName.Owner);
            newImg.setTypeImage(dto.getType());
            newImg.setPathImage(dto.getPathFilename());
            imageRepository.save(newImg);
            PathImage=newImg.getHostImage()+"/"+newImg.getPathImage();
        }
        var result = OwnerInfoMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){ 
        ownerInfoRepository.deleteById(Id);
        return true;
    }
    
    @Override
    public Boolean IsExistedCar(Long CarId){
        var getCar = ownerInfoRepository.findById(CarId);
        return getCar.isPresent();
    }
     @Override
    public Boolean DeleteImage(Long imageId){
        var upload = new UploadImageHandler(OwnerInfoHelper.FolderName.Owner.toLowerCase());
        var image = imageRepository.findById(imageId);
        if(!image.isEmpty()){
            upload.DeleteImage(image.get().getNameImage());
            imageRepository.delete(image.get());
            return true;
        }
        return false;
    }
    
}
