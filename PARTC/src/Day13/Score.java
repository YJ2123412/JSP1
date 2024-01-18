package Day13;

public class Score {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Score(String name, int korean, int english, int math){
        this.name = name;
        this.english=english;
        this.korean=korean;
        this.math=math;
    }

    
    @Override
    public String toString() {
        return "[name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }


    public String datas() {
        return name + "," + korean+ ","+ english+ ","+ math;    
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    
}
