package lab;

public enum Lang {
    English, Polish,
    Japanese, Ukrainian;
    private int n;
    public static Lang fromInt(int n){
        switch (n){
            case 0:{
                return English;
            }
            case 1:{
                return Polish;
            }
            case 2:{
                return Japanese;
            }
            case 3:{
                return Ukrainian;
            }
            default:{
                return null;
            }
        }
    }
}
