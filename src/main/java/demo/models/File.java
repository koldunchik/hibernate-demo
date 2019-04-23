package demo.models;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long fid;

    private Integer width;
    private Integer height;
    private String filepath;

    public File() {
    }

    public File(long id) {
        this.id = id;
    }

    public File(long id, long fid) {
        this.id = id;
        this.fid = fid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;

        File file = (File) o;

        if (id != file.id) return false;
        if (fid != file.fid) return false;
        if (width != null ? !width.equals(file.width) : file.width != null) return false;
        if (height != null ? !height.equals(file.height) : file.height != null) return false;
        return filepath != null ? filepath.equals(file.filepath) : file.filepath == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (fid ^ (fid >>> 32));
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (filepath != null ? filepath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fid=" + fid +
                ", width=" + width +
                ", height=" + height +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}