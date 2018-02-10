package com.company;

public class GameObj {
    private boolean canSee  = true;
    private float topX   = 0.0f; // Top left corner X
    private float topY   = 0.0f; // Top left corner Y
    private float width  = 0.0f; // Width of object
    private float height = 0.0f; // Height of object
    private Colour colour;       // Colour of object
    private int   dirX   = 1;    // Direction X (1 or -1)
    private int   dirY   = 1;    // Direction Y (1 or -1)
    private int timesHit = 0;

    public GameObj(float x, float y, float widthIs, float heightIs, Colour colour) {
      topX = x;
      topY = y;
      width = widthIs;
      height = heightIs;
      this.colour = colour;
    }

    public void setVisibility(boolean state) {
        canSee = state;
    }

    public boolean isVisible() {
        return canSee;
    }

    public float getX() {
        return topX;
    }

    public float getY() {
        return topY;
    }

    public void setTopX(float topX) {
        this.topX = topX;
    }

    public void setTopY(float topY) {
        this.topY = topY;
    }

    public float getWidth() {
        return width;

    }

    public int getTimesHit() {
        return this.timesHit;
    }

    public void increaseTimesHit() {
        this.timesHit++;
    }

    public float getHeight() {
        return height;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour c) {
        this.colour = c;
    }

    public void moveX(float units) {
        topX += units * dirX;
    }

    public void moveY( float units ) {
      topY += units * dirY;
    }

    public void changeDirectionX() {
      dirX = -dirX;
    }

    public void changeDirectionY() {
      dirY = -dirY;
    }

    public boolean hitBy(GameObj obj)
    {
      return !(
              topX >= obj.topX+obj.width
              || topX+width <= obj.topX
              || topY >= obj.topY+obj.height
              || topY+height <= obj.topY
      );

    }

}
