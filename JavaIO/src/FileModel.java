public class FileModel {
    private String url;
    private int lengOfCharacterOfLine;
    private int line;

    FileModel(String url, boolean check, int line) {
        this.url = url;
        this.line = line;
        if(check) lengOfCharacterOfLine = 256;
        else lengOfCharacterOfLine = Integer.MAX_VALUE;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLengOfCharacterOfLine() {
        return lengOfCharacterOfLine;
    }

    public void setLengOfCharacterOfLine(int lengOfCharacterOfLine) {
        this.lengOfCharacterOfLine = lengOfCharacterOfLine;
    }
    
    public int getLine() {
        return line;
    }
}
