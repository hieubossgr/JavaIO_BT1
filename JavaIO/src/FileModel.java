public class FileModel {
    private String url;
    private int lengOfCharacterOfLine;
    private boolean lengOfCharacter;

    FileModel(String url) {
        this.url = url;
        lengOfCharacterOfLine = 256;
        lengOfCharacter = true;
    }

    FileModel(String url, boolean lengOfCharacter, int lengOfCharacterOfLine) {
        this.url = url;
        this.lengOfCharacter = lengOfCharacter;
        this.lengOfCharacterOfLine = lengOfCharacterOfLine;
    }
    
    FileModel(String url, boolean lengOfCharacter) {
        this.url = url;
        this.lengOfCharacter = lengOfCharacter;
    }

    public boolean isLengOfCharacter() {
        return lengOfCharacter;
    }

    public void setLengOfCharacter(boolean lengOfCharacter) {
        this.lengOfCharacter = lengOfCharacter;
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
}
