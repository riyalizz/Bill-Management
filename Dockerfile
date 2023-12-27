FROM maven:3.8.3-openjdk-17-slim
RUN mkdir ElectricitybillManagement
WORKDIR ElectricitybillManagement
COPY ./ ElectricitybillManagement
CMD  cd ElectricitybillManagement && mvn spring-boot:run -Pprod