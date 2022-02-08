package com.form.footballform.models.converters;

import com.form.footballform.models.Position;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Converter
public class StringPositionConverter implements AttributeConverter<List<Position>, String> {
    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<Position> positionList) {
        if(positionList == null){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<positionList.size()-1; i++) {
            stringBuilder.append(positionList.get(i).getId());
            stringBuilder.append("-");
            stringBuilder.append(positionList.get(i).getName());
            stringBuilder.append(";");
        }
        stringBuilder.append(positionList.get(positionList.size()-1));
        return stringBuilder.toString();
    }

    @Override
    public List<Position> convertToEntityAttribute(String string) {
        if(string == null || string.length() == 0) {
            return emptyList();
        }

        String[] strings = string.split(SPLIT_CHAR);
        List<Position> positionList = new ArrayList<>();
        for(String s : strings) {
            String[] idAndName = s.split(SPLIT_CHAR);
            positionList.add(new Position(Long.parseLong(idAndName[0]), idAndName[1]));
        }
        return positionList;
    }
}
