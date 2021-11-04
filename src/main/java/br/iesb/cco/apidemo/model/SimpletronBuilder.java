package br.iesb.cco.apidemo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SimpletronBuilder {
    private final List<String> instructions = new ArrayList<>();
    private final List<String> registers = new ArrayList<>();
    private String name;
    private String description;
    private String model;
    private String brand;
    private float price;
    private int inputBytesCount;
    private int memory;
    private String memoryUnit;

    public SimpletronBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SimpletronBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SimpletronBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public SimpletronBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public SimpletronBuilder withPrice(float price) {
        this.price = price;
        return this;
    }

    public SimpletronBuilder withInputBytesCount(int inputBytesCount) {
        this.inputBytesCount = inputBytesCount;
        return this;
    }

    public SimpletronBuilder withMemory(int memory) {
        this.memory = memory;
        return this;
    }

    public SimpletronBuilder withMemoryUnit(String memoryUnit) {
        this.memoryUnit = memoryUnit;
        return this;
    }

    public SimpletronBuilder addInstruction(String instruction) {
        this.instructions.add(instruction);
        return this;
    }

    public SimpletronBuilder addInstruction(String[] instruction) {
        Collections.addAll(this.instructions, instruction);
        return this;
    }

    public SimpletronBuilder addRegister(String[] registers) {
        Collections.addAll(this.registers, registers);
        return this;
    }

    public SimpletronBuilder addRegister(String register) {
        this.registers.add(register);
        return this;
    }

    public SimpletronEntity build() {
        return new SimpletronEntity(0, name, description, model, brand, price,
            inputBytesCount, memory, memoryUnit, registers, instructions, new Date(),
            null);
    }

}
