package hcmute.edu.vn.firebase;

public class Model_Image {

    //Field
    private String imageUri;
    public Model_Image(){

    }

    //Constructor
    public Model_Image(String imageUri) {
        this.imageUri = imageUri;
    }

    //Getter and Setter
    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
