package com.pedrolemoz.academic.configurations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pedrolemoz.academic.models.TeacherModel;

import java.io.IOException;

public class CustomTeacherModelSerializer extends StdSerializer<TeacherModel> {
    public CustomTeacherModelSerializer() {
        this(null);
    }

    public CustomTeacherModelSerializer(Class<TeacherModel> value) {
        super(value);
    }

    @Override
    public void serialize(
            TeacherModel value,
            JsonGenerator jsonGenerator,
            SerializerProvider arg2
    ) throws IOException {
        jsonGenerator.writeString(value.getId().toString());
    }
}