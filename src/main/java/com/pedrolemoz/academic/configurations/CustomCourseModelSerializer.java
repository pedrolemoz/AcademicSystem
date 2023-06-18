package com.pedrolemoz.academic.configurations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pedrolemoz.academic.models.CourseModel;

import java.io.IOException;

public class CustomCourseModelSerializer extends StdSerializer<CourseModel> {
    public CustomCourseModelSerializer() {
        this(null);
    }

    public CustomCourseModelSerializer(Class<CourseModel> value) {
        super(value);
    }

    @Override
    public void serialize(
            CourseModel value,
            JsonGenerator jsonGenerator,
            SerializerProvider arg2
    ) throws IOException {
        jsonGenerator.writeString(value.getId().toString());
    }
}