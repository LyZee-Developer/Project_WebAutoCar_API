#!/bin/bash
comment="$1"
if [[ -z $1 ]]; then 
    echo "We need comment ❌" 
    echo "Please enter text something what you do ... 🗒️✏️" 
fi
git add .
git commit 
