// Name: Zheng Hao Tan
// Email: tanzhao@umich.edu
// Date: December 24, 2012

// I got so bored that I decided to do this on Christmas eve. Muhahaha! :D

import java.awt.*;
import java.util.*;
//public static final int LENGTH = 500;
//public static final int WIDTH = 700;
//public static final int SNOWSIZE = 5;
public class ChristmasTree1 
{
	public static void main(String[]args)
	{
		Random rand = new Random();
		
		// Start with a red background.
		DrawingPanel panel = new DrawingPanel(700, 700);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.RED);
		
		drawBackground(g, rand);
		drawTree(g, rand);
		drawSnowman(g);
		drawMessage(g);
	}
	
	/**
	 *  This method draws the background of the Christmas card.
	 * @param g
	 * @param rand
	 */
	public static void drawBackground(Graphics g, Random rand)
	{
		// The top and bottom part of the card.
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 700, 700/5);
		g.fillRect(0, 700*4/5, 700, 700/5);
		
		// Background for the Christmas tree.
		g.setColor(Color.CYAN);
		g.fillRect(700/5, 700/5, 700*3/5, 700*3/5);
		
		// Snow.
		g.setColor(Color.WHITE);
		
		for(int i = 0; i < 200; ++i)
		{
			int snowX = rand.nextInt(700*3/5-5)+ 700/5;
			int snowY = rand.nextInt(700*3/5-5)+ 700/5;
			g.fillOval(snowX, snowY, 5, 5);
		}
	}
	
	/**
	 *  This method draws the Christmas tree, including the bells and lighting.
	 * @param g
	 * @param rand
	 */
	public static void drawTree(Graphics g, Random rand)
	{
		g.setColor(Color.GREEN);
		
		// Do it from bottom up and decrease the size of the lines.
		int size = 0;
		
		while (size <= 150) {
			g.drawLine(200+size,  400-size, 500-size, 400-size);
			++size;
		}
		
		// This for loop draws the bells on the tree.
		int count = 0;
		do
		{
			// Choose between 4 different colors.
			int color = rand.nextInt(5)+ 1; 
			
			if (color == 1)
				g.setColor(Color.RED);
			else if (color == 2)
				g.setColor(Color.BLUE);
			else if (color == 3)
				g.setColor(Color.YELLOW);
			else
				g.setColor(Color.CYAN);
				
			
			int bellX = rand.nextInt(301)+ 200;
			int bellY = rand.nextInt(151)+ 250;
			
			if (bellX < 250) {
				
				if(bellY < (bellY/bellX*bellX)) {
					g.fillOval(bellX, bellY, 8, 8);
					g.setColor(Color.BLACK);
					g.drawOval(bellX, bellY, 8, 8);
					++count;
				}
			}
			else if (bellX > 250) {
				
				if(bellX< bellX/bellY*bellX) {
					g.fillOval(bellX, bellY, 8, 8);
					g.setColor(Color.BLACK);
					g.drawOval(bellX, bellY, 8, 8);
					++count;
				}
			}
		} while (count <= 50);
	}
	
	/**
	 * This method draws the snowman on the drawing board.
	 * @param g
	 */
	public static void drawSnowman(Graphics g)
	{	
		for(int i = 0; i < 2; ++i)
		{
			//Body.
			g.setColor(Color.WHITE);
			g.fillOval(500/20 + (700-120-500/30)*i, 700/2-80, 80, 80);
			g.fillOval(500/30 + (700-120-500/30)*i, 700/2, 100, 700/6);
			
			// Nose and hat.
			//g.fillOval()
			g.setColor(Color.BLACK);
			g.fillRect(500/12 + (700 - 2*500/12 - 50)*i, 700/2-130, 45, 50);
			
			//Eyes.
			g.setColor(Color.BLACK);
			g.fillOval(500/12 + (700- 2*500/12 - 10)*i, 300, 10, 10);
			g.fillOval(500/12 + 40 + (700-(2*(500/12 + 40)) - 10)*i, 300, 10, 10);
		}
	}
	
	/**
	 * This method prints out the Christmas message.
	 * @param g
	 */
	public static void drawMessage(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 36));
		g.drawString("MERRY CHRISTMAS!", 700/4, 700/10);
	}
}
