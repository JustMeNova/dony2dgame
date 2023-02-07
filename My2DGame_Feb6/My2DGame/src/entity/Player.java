package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
// import java.awt.Color;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    } 

    public void setDefaultValues() {

        x= 100;
        y = 100;
        speed = 4;
        direction = "down"; // default direction
    }

    public void getPlayerImage() {

        try {
            left = ImageIO.read(new FileInputStream("src/res/player/Monkey_left.png"));
            right = ImageIO.read(new FileInputStream("src/res/player/Monkey_right.png"));
            up = ImageIO.read(new FileInputStream("src/res/player/Monkey_up.png"));
            down = ImageIO.read(new FileInputStream("src/res/player/Monkey_down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction ="right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
        case "left":
            image = left;
            break;
        case "right":
            image = right;
            break;
        case "up":
            image = up;
            break;
        case "down":
            image = down;
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
