public class Student {
    private String MSV, name, gender;
    private double pypoint, japoint, avg;
    private String result;

    public Student(String mSV, String name, String gender, double pypoint, double japoint) {
        MSV = mSV;
        this.name = name;
        this.gender = gender;
        this.pypoint = pypoint;
        this.japoint = japoint;
        this.avg = (japoint * 2 + pypoint) / 3;
        this.result = CheckResult();
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String mSV) {
        MSV = mSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPypoint() {
        return pypoint;
    }

    public void setPypoint(double pypoint) {
        this.pypoint = pypoint;
    }

    public double getJapoint() {
        return japoint;
    }

    public void setJapoint(double japoint) {
        this.japoint = japoint;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    } 
    @Override
    public String toString() {
        return "Student [MSV=" + MSV + ", name=" + name + ", gender=" + gender + ", pypoint=" + pypoint + ", japoint="
                + japoint + ", avg=" + avg + ", result=" + result + "]";
    }
    public String CheckResult() {
        if (this.avg >= 5) {
            return "Dau";
        } else if ("nam".equals(gender)) {
            return "Truot";
        } else {
            return "Dau";
        }

    }
}
