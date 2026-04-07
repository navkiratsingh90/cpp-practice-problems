class Robot {
    int xSize;
    int ySize;
    int currX = 0;
    int currY = 0;
    int dim;
    String[] dirs = new int[]{"East","North","West","South"};
    int dir = 0;
    public Robot(int width, int height) {   
        dim = width*height;
        xSize = width-1;
        ySize = height-1;
    }
    
    public void step(int num) {
        int dist = num%dim;
        int cnt = 4;
        while (cnt > 0){
            if ((dirs[dir].equals("East") && currX + dist > Xsize) || (dirs[dir].equals("North") && currY + dist > Ysize) || (dirs[dir].equals("West") && currX - dist < 0) || (dirs[dir].equals("South") && currY - dist < 0)){
                if (dirs[dir].equals("East")){
                    dist -= xSize - currX;
                    dir = (dir + 1)%4;
                    currX = xSize;
                }
                else if (dirs[dir].equals("North")){
                    dist -= ySize - currY;
                    dir = (dir+1)%4;
                    currY = ySize;
                }
                else if (dirs[dir].equals("West")){
                    dist -= xSize - (xSize - currX);
                    dir = (dir+1)%4;
                    currX = 0;
                }
                else{
                    dist -= ySize - (ySize - currY);
                    dir = (dir+1)%4;
                    currY = 0;
                }
            }
            else{
                if (dirs[dir].equals("East")){
                    currX += dist;
                }
                else if (dirs[dir].equals("North")){
                    currY += dist;
                }
                else if (dirs[dir].equals("West")){
                    currX -= dist;
                }
                else{
                    currY -= dist;
                }
            }
        }
    }
    
    public int[] getPos() {
        
    }
    
    public String getDir() {
        
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
