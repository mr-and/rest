package testproject.restApp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DOCS")
public class Docs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "data")
    private Integer data;
    @Column(name = "number")
    private Integer number;
    @Column(name = "sum")
    private Integer sum;

    public Docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "id=" + id +
                ", number=" + number +
                ", data=" + data +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docs docs = (Docs) o;
        return id == docs.id &&
                data.equals(docs.data) &&
                number.equals(docs.number) &&
                sum.equals(docs.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, number, sum);
    }
}
