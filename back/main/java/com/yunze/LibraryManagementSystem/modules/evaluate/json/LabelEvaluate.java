package com.yunze.LibraryManagementSystem.modules.evaluate.json;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;

public class LabelEvaluate {
    private Label label;
    private Evaluate evaluate;

    public LabelEvaluate() {
    }

    public LabelEvaluate(Label label, Evaluate evaluate) {
        this.label = label;
        this.evaluate = evaluate;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Evaluate getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return "LabelEvaluate{" +
                "label=" + label +
                ", evaluate=" + evaluate +
                '}';
    }
}
