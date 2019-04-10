net stop docker
net stop com.docker.service
taskkill /IM "dockerd.exe" /F
taskkill /IM "Docker for Windows.exe" /F
net start docker
net start com.docker.service
"c:\program files\docker\docker\Docker for Windows.exe"