#!/bin/bash
kind create cluster --image kindest/node:v1.25.3 --name dev-kind

#check the kind cluster 
docker ps