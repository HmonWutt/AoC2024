import java.util.ArrayList;

public class Robot {
    private Integer originalX;
    private Integer getOriginalY;
    private Integer currentX;
    private Integer currentY;
    private Integer movementX;
    private Integer movementY;
    private Integer height;
    private Integer width;
    public Robot(Integer startingX, Integer startingY, Integer movementX, Integer movementY, Integer height, Integer width){
        this.currentX = startingX;
        this.currentY = startingY;
        this.movementY = movementY;
        this.movementX = movementX;
        this.height = height+1;
        this.width = width+1;
    }
    public Integer getCurrentX() {
        return this.currentX;
    }
    public Integer getCurrentY() {
        return this.currentY;
    }
    public void setCurrentX() {
        this.currentX+=this.movementX;
        if (this.currentX < 0) this.currentX = (width+this.currentX);
        this.currentX = this.currentX%width;

    }
    public void setCurrentY(){
        this.currentY +=this.movementY;
        if (this.currentY < 0) this.currentY = (height+this.currentY);
        this.currentY = this.currentY%height;
    }
    public void updatePosition(){
        setCurrentX();
        setCurrentY();
    }

}
