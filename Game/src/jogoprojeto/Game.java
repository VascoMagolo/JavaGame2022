package jogoprojeto;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Game extends JFrame implements KeyListener{
    BufferedImage backBuffer;
    int FPS=100;
    int janelaW=700;
    int janelaH=700;
    int c=1;
    int se=-1;
    int mf=0;
    int color;
    int coloritem;
    rect Sprite=new rect(12,307, 40, 25, 25);  
    rect boost=new rect(1,10, 10, 25, 25);  
    Ficheiros ficheiro=new Ficheiros();
    ImageIcon lvl;
    InputStream in;
    AudioStream audio; 
    Graphics g,bbg;
    BufferedImage img;
    int nivel=1;
    int rx;
    int ry;
    int lx;
    int ly;
    int x,y;
    int tentativas = 5;
    private int velocidade=3;
    int ganhou=1;
    String nome="";
    String pontos=String.valueOf(nivel);
    static int contador=1;
    Random random = new Random();
    int xitem = random.nextInt(700)+1;
    int yitem = random.nextInt(700)+30;
    ImageIcon vida = new ImageIcon("src/images/heart.png");

    
   public void run() {
     inicializar();
     while (tentativas>=0 && ganhou==1 ) {
         desenharGraficos();
         try {
             Thread.sleep(1000/ FPS);
         }
         catch (Exception e) {
             System.out.println("Thread interrompida!");
         }
     }
     if (ganhou==0) {
        AudioPlayer.player.stop(audio);
        GameOver go = new GameOver();
        this.dispose();
        go.run();
     }
     else {
         //Winner lvl = new Winner(nivel);
         //this.dispose();
         //lvl.run();
     }
 }
    public void inicializar(){    
        this.setSize(700, 700);  
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/images/boost.png");  
        setIconImage(icon.getImage());  
        setTitle("Confusion - Nivel " + nivel);
        setSize(janelaW, janelaH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        final JFrame parent = new JFrame();
        nome=JOptionPane.showInputDialog(parent,"qual o seu nome?", null);
        musicBate();  
        lvl = new ImageIcon("nivel" + nivel + ".png");
        boost.cenas[0]=new ImageIcon("src/images/boost.png");
        personagem();
        spawn();
        ficheiro.Existe("src/jogoprojeto/scores.txt");
        if (true){
            ficheiro.InsereLinhasFicheiro("src/jogoprojeto/scores.txt", nome, pontos);
        }
        else{
            ficheiro.CriaFicheiro("src/jogoprojeto/scores.txt");
        }
        
        
        backBuffer = new BufferedImage(janelaW, janelaH,BufferedImage.TYPE_INT_RGB);
        setTitle("The Confusion Game-Beta");
        setLocationRelativeTo(null);
        addKeyListener(this); 
    }
    public void colidesprites(){
        Rectangle areaSprite = Sprite.getLimiteSprite();
        Rectangle areaboost = boost.getLimiteSprite();
        if ((areaSprite.intersects(areaboost))||(areaboost.intersects(areaSprite))){
            velocidade=20;
        }
    }
    public void desenharGraficos() {
        g=getGraphics();
        bbg=backBuffer.getGraphics();
        try {
        img = ImageIO.read(new File("src/images/nivel"+nivel + ".png"));
        color = img.getRGB(Sprite.x, Sprite.y );
        System.out.println(color);
        coloritem = img.getRGB(xitem, yitem);
        System.out.println(color);
        bbg.setColor(Color.WHITE);
        }  
        catch (IOException e) {
        e.printStackTrace();
        }
        cores();
        bbg.setColor(Color.WHITE);
        bbg.drawImage(img,0,0,this);
        bbg.drawImage(Sprite.cenas[0].getImage(), Sprite.x,Sprite.y,Sprite.tamanho,Sprite.tamanho2,this);
        coresitem();
        colidesprites();
        
    if (tentativas == 5) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
        bbg.drawImage(vida.getImage(), 35, 27, this);
        bbg.drawImage(vida.getImage(), 60, 27, this);
        bbg.drawImage(vida.getImage(), 85, 27, this);
        bbg.drawImage(vida.getImage(), 110, 27, this);
        bbg.drawImage(vida.getImage(), 135, 27, this);
    }
    if (tentativas == 4) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
        bbg.drawImage(vida.getImage(), 35, 27, this);
        bbg.drawImage(vida.getImage(), 60, 27, this);
        bbg.drawImage(vida.getImage(), 85, 27, this);
        bbg.drawImage(vida.getImage(), 110, 27, this);
    }
    if (tentativas == 3) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
        bbg.drawImage(vida.getImage(), 35, 27, this);
        bbg.drawImage(vida.getImage(), 60, 27, this);
        bbg.drawImage(vida.getImage(), 85, 27, this);
    }
    if (tentativas == 2) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
        bbg.drawImage(vida.getImage(), 35, 27, this);
        bbg.drawImage(vida.getImage(), 60, 27, this);
    }
    if (tentativas == 1) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
        bbg.drawImage(vida.getImage(), 35, 27, this);
    }
    if (tentativas == 0) {
        bbg.drawImage(vida.getImage(), 10, 27, this);
    }
    if(tentativas < 0){
        ganhou=0;
    }
        g.drawImage(backBuffer,0,0,this);
    }
    public void spawn(){
        if(nivel==1){
            Sprite.x=307;
            Sprite.y=40; 
        }
        if(nivel==2){
            Sprite.x=320;
            Sprite.y=30; 
        }
        if(nivel==3){
            Sprite.x=635;
            Sprite.y=30; 
        }
    }
    public static void musicBate(){
    try{
    InputStream in=new FileInputStream("src/music/beat.wav");
    AudioStream audio = new AudioStream (in);
    AudioPlayer.player.start(audio);
    } catch (IOException e) {System.out.println("erro: "+e.getMessage());}
    }
    public void personagem(){
        if (customizar.cena==1){
        Sprite.cenas[0] = new ImageIcon("src/images/quadrado.png");
        }
        if (customizar.cena==2){
        Sprite.cenas[0] = new ImageIcon("src/images/p0.png");
        Sprite.cenas[1] = new ImageIcon("src/images/p1.png"); 
        Sprite.cenas[2] = new ImageIcon("src/images/p2.png"); 
        Sprite.cenas[3] = new ImageIcon("src/images/p3.png"); 
        Sprite.cenas[4] = new ImageIcon("src/images/p4.png"); 
        Sprite.cenas[5] = new ImageIcon("src/images/p5.png"); 
        Sprite.cenas[6] = new ImageIcon("src/images/p6.png"); 
        Sprite.cenas[7] = new ImageIcon("src/images/p7.png");
        Sprite.cenas[8] = new ImageIcon("src/images/p8.png"); 
        Sprite.cenas[9] = new ImageIcon("src/images/p9.png"); 
        Sprite.cenas[10] = new ImageIcon("src/images/p10.png");
        Sprite.cenas[11] = new ImageIcon("src/images/p11.png"); 
        }
    }
    public void cores() {
    //Preto | Perdeu
    if (color < -14500000 && color> -19000000){
        tentativas--;
        spawn();
    } 
    //Verde | Ganhou
    if (color == -14372785){
        nivel++;
    }
    }
    public void coresitem() {
    //Branco | Caminho
    if (color == -1) {    
        bbg.drawImage(boost.cenas[0].getImage(), xitem, yitem, this); 
    }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {  
    if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            Sprite.y=Sprite.y+velocidade;
            Sprite.animar_cima(0);
        }    
    if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            Sprite.y=Sprite.y-velocidade;
            Sprite.animar_baixo(3);
        }  
    if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            Sprite.x=Sprite.x-velocidade;
            Sprite.animar_esquerda(6);
        }  
    if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            Sprite.x=Sprite.x+velocidade;
            Sprite.animar_direita(9);
        }  
    }

    @Override
    public void keyReleased(KeyEvent e) {  
    }
}
