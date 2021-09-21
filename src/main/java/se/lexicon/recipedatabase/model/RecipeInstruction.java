package se.lexicon.recipedatabase.model;

import java.util.Objects;

public class RecipeInstruction {

    private String instructionId;

    private String instruction;

    public RecipeInstruction(String instructionId, String instruction) {
        this.instructionId = instructionId;
        this.instruction = instruction;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return getInstructionId().equals(that.getInstructionId()) && getInstruction().equals(that.getInstruction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstructionId(), getInstruction());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
