import java.util.ArrayList;

public class CheckEnemyHit {

    Enemy enemy;
    Player player;
    GameScreen gameScreen;
    Hability hability;

    ArrayList<Integer> teste = new ArrayList<Integer>();

    int enemyCooldown = -1;

    CheckEnemyHit(){

    }

    public void update(Enemy enemy, Player player, GameScreen gameScreen, Hability hability){

        this.enemy = enemy;
        this.player = player;
        this.gameScreen = gameScreen;
        this.hability = hability;

        for(int i = 0; i < enemy.bullets.size(); i++){
            enemy.bullets.get(i).rectangle.x = (int) enemy.bullets.get(i).x;
            enemy.bullets.get(i).rectangle.y = (int) enemy.bullets.get(i).y;
            if(enemy.bullets.get(i).die){
                enemy.bullets.remove(i);
                enemy.angles.remove(i);
            }
            if(gameScreen.lua == 0){
                if(enemy.bullets.get(i).rectangle.intersects(player.rectangle) 
                    && hability.immortal == false){
                    // System.out.println("AIN PAINHO");
                    enemy.bullets.remove(i);
                    player.hittedBullet = true;
                    player.hitAngle = enemy.angles.get(i);
                    player.vida--;
                    player.levouDano = true;
                    gameScreen.lua++;
                    enemy.angles.remove(i);
                }
            }
        }

        if(gameScreen.lua == 0){
            if(enemy.rectangle.intersects(gameScreen.rectangleP) && hability.immortal == false 
                && enemy.finishState == false && enemy.deadState == false){
                // System.out.println(nume);
                player.hittedEnemy = true;
                player.hittedAngle = enemy.theta;
                enemy.hittedPlayer = true;
                if(enemy.vX == 0 && enemy.vY == 0){
                    player.knockback = false;
                } else {
                    player.knockback = true;
                }
                player.vida--;
                player.levouDano = true;
                // gameScreen.nume++;
                gameScreen.lua++;
            }
        }

        for(int i = 0; i < player.bullets.size(); i++){
            if(player.bullets.get(i).rectangle.intersects(enemy.rectangle)){
                // player.bullets.remove(i);
                // System.out.println("PARA");
                if(player.bullets.get(i).die){
                    player.bullets.remove(i);
                    player.angles.remove(i);
                }
                enemy.hittedBullet = true;
                enemy.anglinho = player.angles.get(i);
                if(player.bullets.get(i).perfurante == false){
                    player.bullets.remove(i);
                    player.angles.remove(i);
                }
                gameScreen.sol++;
            }
        }

        if(enemy.rectangle.intersects(gameScreen.rectangleP) && hability.buffalo){
            enemy.hittedPlayer = true;
            if(enemyCooldown == -1){
                enemy.life--;
                enemyCooldown++;
            }
        }

        if(enemyCooldown >= 0){
            enemyCooldown++;
            if(enemyCooldown >= 60){
                enemyCooldown = -1;
            }
        }

        if(gameScreen.sol > 0){
            gameScreen.sol++;
            if(gameScreen.sol > 60){
                gameScreen.sol = 0;
            }
        }

    }

}
