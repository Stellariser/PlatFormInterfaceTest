package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatasetToClasscification {
    private int id;
    private int dataset_id;
    private int classcification_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataset_id() {
        return dataset_id;
    }

    public void setDataset_id(int dataset_id) {
        this.dataset_id = dataset_id;
    }

    public int getClasscification_id() {
        return classcification_id;
    }

    public void setClasscification_id(int classcification_id) {
        this.classcification_id = classcification_id;
    }
}
