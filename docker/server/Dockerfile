
FROM openjdk:8-jre

# 切换apt源为http清华源
RUN echo "deb http://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye main contrib non-free" > /etc/apt/sources.list && \
echo "deb http://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye-updates main contrib non-free" >> /etc/apt/sources.list && \
echo "deb http://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye-backports main contrib non-free" >> /etc/apt/sources.list && \
echo "deb http://mirrors.tuna.tsinghua.edu.cn/debian-security bullseye-security main contrib non-free" >> /etc/apt/sources.list && \
apt-get clean && apt-get update
# 安装/更新证书ca-certificates
RUN apt-get install --reinstall ca-certificates -y
# 切换apt源为https清华源，并安装vim ping telnet命令
RUN echo "deb https://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye main contrib non-free" > /etc/apt/sources.list && \
echo "deb https://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye-updates main contrib non-free" >> /etc/apt/sources.list && \
echo "deb https://mirrors.tuna.tsinghua.edu.cn/debian/ bullseye-backports main contrib non-free" >> /etc/apt/sources.list && \
echo "deb https://mirrors.tuna.tsinghua.edu.cn/debian-security bullseye-security main contrib non-free" >> /etc/apt/sources.list && \
apt-get clean && apt-get update && apt-get install -y vim iputils-ping telnet
#安装中文字体
RUN apt-get install ttf-wqy-microhei

# 安装chrome浏览器及其驱动参考文档：https://blog.csdn.net/eason_hsmm/article/details/135364772
# chrome浏览器下载地址：https://www.google.cn/intl/zh-CN/chrome/next-steps.html?platform=linux&statcb=0&installdataindex=empty&defaultbrowser=0，点击底部【其他平台】
# 安装chrome浏览器122.0.6261.94
#COPY google-chrome-stable_current_amd64.deb /inspection/
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN chmod +x /google-chrome-stable_current_amd64.deb

# 此处会出现依赖关系错误执行失败，使用||true使执行失败时继续往下执行
RUN dpkg -i /google-chrome-stable_current_amd64.deb || true
# 修复apt-get依赖关系
RUN apt-get install -f -y
# 再次执行安装chrome浏览器命令
RUN dpkg -i /google-chrome-stable_current_amd64.deb


MAINTAINER inspection
EXPOSE 9091
LABEL version="1.0.1" description="线上巡检server镜像" by="inspection"

COPY onlineInspect.jar /inspection/

CMD java -jar /inspection/onlineInspect.jar
