package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DAO {

    public static List<Consumo> read(){
        List<Consumo> consumos = new ArrayList<Consumo>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream jsonStream;
            jsonStream = new FileInputStream(new File("D:/workspace/java/first_app/demo/consumoOut.json"));
            TypeReference<List<Consumo>> typeReference = new TypeReference<List<Consumo>>(){};
            consumos = mapper.readValue(jsonStream, typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return consumos;
    }

    public static void update(List<Consumo> consumos){
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Consumo c : consumos){
            ObjectNode current_object = mapper.createObjectNode();
            current_object.put("date", c.getDate());
            current_object.put("type", c.getType());
            current_object.put("fuel", c.getFuel());
            current_object.put("kilometers", c.getKilometers());
            current_object.put("rendimento", c.getKilometers()/c.getFuel());
            arrayNode.add(current_object);
        }
        try {
            mapper.writeValue(new File("D:/workspace/java/first_app/demo/consumoOut.json"), arrayNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void delete(List<Consumo> consumos, Consumo c){

    }
}
