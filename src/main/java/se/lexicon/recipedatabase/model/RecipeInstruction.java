package se.lexicon.recipedatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String instructionId;

    private String instructions;

    public RecipeInstruction(String instructionId, String instruction) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public RecipeInstruction() {

    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return getInstructionId().equals(that.getInstructionId()) && getInstructions().equals(that.getInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstructionId(), getInstructions());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
