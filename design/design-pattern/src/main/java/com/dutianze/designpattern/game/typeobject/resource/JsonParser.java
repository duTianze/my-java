package com.dutianze.designpattern.game.typeobject.resource;

import com.dutianze.designpattern.game.typeobject.Breed;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/8/20
 */
public class JsonParser {

    private final TypeToken<Map<String, Breed>> BREED_JSON_TYPE = new TypeToken<>() {
    };
    private final Gson GSON = new Gson();

    public Collection<Breed> loadBreed() throws FileNotFoundException {
        String workingDirectory = new File("").getAbsolutePath();
        List<String> filePath =
                List.of("src", "main", "java", "com", "dutianze", "designpattern", "game", "typeobject", "resource",
                        "breed.json");
        String absolutePath = workingDirectory + File.separator + String.join(File.separator, filePath);
        Reader reader = new FileReader(absolutePath);

        Map<String, Breed> breedMap = GSON.fromJson(reader, BREED_JSON_TYPE.getType());
        setNameAndParent(breedMap);
        return breedMap.values();
    }

    private void setNameAndParent(Map<String, Breed> breedMap) {
        for (Map.Entry<String, Breed> entry : breedMap.entrySet()) {
            Breed parent = Optional.ofNullable(entry.getValue().getParent())
                                   .map(p -> breedMap.get(p.getName()))
                                   .orElse(null);
            Breed breed = entry.getValue();
            breed.setName(entry.getKey());
            breed.setParent(parent);
            if (parent != null) {
                if (breed.getHealth() == 0) {
                    breed.setHealth(parent.getHealth());
                }
                if (breed.getAttack() == null) {
                    breed.setAttack(parent.getAttack());
                }
            }
        }
    }

    public static class ParentAdapterFactory implements TypeAdapterFactory {

        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            return (TypeAdapter<T>) new ParentAdapter(gson);
        }
    }

    private static class ParentAdapter extends TypeAdapter<Breed> {

        private final Gson gson;

        public ParentAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override
        public void write(JsonWriter jsonWriter, Breed guid) {
            throw new RuntimeException("Not implemented");
        }

        @Override
        public Breed read(JsonReader jsonReader) throws IOException {
            return switch (jsonReader.peek()) {
                case STRING -> new Breed(null, jsonReader.nextString(), 0, null);
                case BEGIN_OBJECT -> gson.fromJson(jsonReader, Breed.class);
                default -> throw new RuntimeException("Expected object or string, not " + jsonReader.peek());
            };
        }
    }
}