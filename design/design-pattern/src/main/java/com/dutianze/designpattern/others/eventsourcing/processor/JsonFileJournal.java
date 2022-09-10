package com.dutianze.designpattern.others.eventsourcing.processor;

import com.dutianze.designpattern.others.eventsourcing.event.AccountCreateEvent;
import com.dutianze.designpattern.others.eventsourcing.event.DomainEvent;
import com.dutianze.designpattern.others.eventsourcing.event.MoneyDepositEvent;
import com.dutianze.designpattern.others.eventsourcing.event.MoneyTransferEvent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/9/11
 */
public class JsonFileJournal {

    private final File file;
    private final List<String> events = new ArrayList<>();
    private int index = 0;

    public static final String JSON_FILE_PATH = "Journal.json";

    public JsonFileJournal() {
        file = new File(JSON_FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = input.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(DomainEvent domainEvent) {
        Gson gson = new Gson();
        JsonElement jsonElement;
        if (domainEvent instanceof AccountCreateEvent) {
            jsonElement = gson.toJsonTree(domainEvent, AccountCreateEvent.class);
        } else if (domainEvent instanceof MoneyDepositEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyDepositEvent.class);
        } else if (domainEvent instanceof MoneyTransferEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyTransferEvent.class);
        } else {
            throw new RuntimeException("Journal Event not recognized");
        }

        try (BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
            String eventString = jsonElement.toString();
            output.write(eventString + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DomainEvent readNext() {
        if (index >= events.size()) {
            return null;
        }
        String event = events.get(index);
        index++;

        JsonElement jsonElement = JsonParser.parseString(event);
        String eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
        Gson gson = new Gson();
        DomainEvent domainEvent = switch (eventClassName) {
            case "AccountCreateEvent" -> gson.fromJson(jsonElement, AccountCreateEvent.class);
            case "MoneyDepositEvent" -> gson.fromJson(jsonElement, MoneyDepositEvent.class);
            case "MoneyTransferEvent" -> gson.fromJson(jsonElement, MoneyTransferEvent.class);
            default -> throw new RuntimeException("Journal Event not recognized");
        };

        domainEvent.setRealTime(false);
        return domainEvent;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void reset() {
        file.delete();
    }
}
