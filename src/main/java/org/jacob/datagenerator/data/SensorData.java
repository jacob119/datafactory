package org.jacob.datagenerator.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class SensorData {
    private String id;
    private String eventTime;
    private double temperature;
}
