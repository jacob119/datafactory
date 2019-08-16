package org.jacob.datagenerator.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.fluttercode.datafactory.impl.DataFactory;
import org.jacob.datagenerator.data.SensorData;
import org.jacob.datagenerator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SensorDataFactory {

    @Autowired
    private DataFactory dataFactory;

    @Autowired
    private ObjectMapper objectMapper;

    public SensorData getGenerator(){
        String[] ids = new String[]{"1"};
        Double[] temp = {0.89,0.21,0.93,0.44,0.88, 0.99, 0.23};
        SensorData sensorData = new SensorData(dataFactory.getItem(ids),
                DateUtil.getThisDay("yyyymmddhhmmssms"),
                dataFactory.getItem(temp,90, 0.01));
        return sensorData;
    }

    public String getJson() {
        try {
            return  objectMapper.writeValueAsString(getGenerator());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
