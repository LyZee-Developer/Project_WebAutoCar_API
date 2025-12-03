#!/bin/bash
comment="$1"
if [[ -z $1 ]]; then 
    echo "We need comment ❌" 
    echo "Please enter text something what you do ... 🗒️✏️" 
    exit 1
fi
git add .
git commit -m "$comment"
git push
