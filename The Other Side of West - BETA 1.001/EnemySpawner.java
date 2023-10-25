import java.util.ArrayList;
import java.util.Random;

public class EnemySpawner {

    int quantEnemyCima, quantEnemyBaixo, quantEnemyDireita, quantEnemyEsquerda;
    int position;
    int maxNumEnemy = 1;

    Random random = new Random();

    int skin;
    int type;

    EnemySpawner(){
    }

    public void update(ArrayList<Enemy> enemy, ArrayList<CheckEnemyHit> checkEnemyHit, 
        int tPlayerX, int tPlayerY, int moment){

            if(moment < 7){
                if(moment == 1){
                    maxNumEnemy = 1;
                } else if(moment == 2){
                    maxNumEnemy = 2;
                } else if(moment == 3){
                    maxNumEnemy = 3;
                } else if(moment > 3){
                    maxNumEnemy = random.nextInt(2) + 1;
                }
                quantEnemyCima = random.nextInt(maxNumEnemy) + 1;
                quantEnemyBaixo = random.nextInt(maxNumEnemy) + 1;
                quantEnemyDireita = random.nextInt(maxNumEnemy) + 1;
                quantEnemyEsquerda = random.nextInt(maxNumEnemy) + 1;

                int quantEnemys;
                quantEnemys = quantEnemyCima + quantEnemyBaixo + quantEnemyDireita + quantEnemyEsquerda;

                int size = enemy.size();

                for(int i = size; i < (size + quantEnemys); i++){
                    position = random.nextInt(12) + 1;
                    skin = random.nextInt(2) + 1;
                    // type = random.nextInt(2) + 1;
                    if(moment < 3){
                        type = 1;
                    }
                    enemy.add(new Enemy(type, skin, moment));
                    checkEnemyHit.add(new CheckEnemyHit());
                    if(quantEnemyCima > 0){
                        enemy.get(i).y = tPlayerY - 800;
                        enemy.get(i).x = tPlayerX;
                        quantEnemyCima--;
                    } else if(quantEnemyBaixo > 0){
                        enemy.get(i).y = tPlayerY + 800;
                        enemy.get(i).x = tPlayerX;
                        quantEnemyBaixo--;
                    } else if(quantEnemyDireita > 0){
                        enemy.get(i).x = tPlayerX + 800;
                        enemy.get(i).y = tPlayerY;
                        quantEnemyDireita--;
                    } else if(quantEnemyEsquerda > 0){
                        enemy.get(i).x = tPlayerX - 800;
                        enemy.get(i).y = tPlayerY;
                        quantEnemyEsquerda--;
                    }
                    if(enemy.get(i).x == tPlayerX){
                        if(position == 1){
                            enemy.get(i).x += 100;
                        } else if(position == 2){
                            enemy.get(i).x += 200;
                        } else if(position == 3){
                            enemy.get(i).x += 300;
                        } else if(position == 4){
                            enemy.get(i).x += 400;
                        } else if(position == 5){
                            enemy.get(i).x += 500;
                        } else if(position == 6){
                            enemy.get(i).x += 600;
                        } else if(position == 7){
                            enemy.get(i).x -= 100;
                        } else if(position == 8){
                            enemy.get(i).x -= 200;
                        } else if(position == 9){
                            enemy.get(i).x -= 300;
                        } else if(position == 10){
                            enemy.get(i).x -= 400;
                        } else if(position == 11){
                            enemy.get(i).x -= 500;
                        } else if(position == 12){
                            enemy.get(i).x -= 600;
                        }
                    }
                    if(enemy.get(i).y == tPlayerY){
                        if(position == 1){
                            enemy.get(i).y += 100;
                        } else if(position == 2){
                            enemy.get(i).y += 200;
                        } else if(position == 3){
                            enemy.get(i).y += 300;
                        } else if(position == 4){
                            enemy.get(i).y += 400;
                        } else if(position == 5){
                            enemy.get(i).y += 500;
                        } else if(position == 6){
                            enemy.get(i).y += 600;
                        } else if(position == 7){
                            enemy.get(i).y -= 100;
                        } else if(position == 8){
                            enemy.get(i).y -= 200;
                        } else if(position == 9){
                            enemy.get(i).y -= 300;
                        } else if(position == 10){
                            enemy.get(i).y -= 400;
                        } else if(position == 11){
                            enemy.get(i).y -= 500;
                        } else if(position == 12){
                            enemy.get(i).y -= 600;
                        }
                    }
                }
            } else if(moment == 100){
                type = 100;
                skin = 0;
                enemy.add(new Enemy(type, skin, 100));
                checkEnemyHit.add(new CheckEnemyHit());
                for(int i = 0; i < enemy.size(); i++){
                    enemy.get(i).x = tPlayerX + 500;
                    enemy.get(i).y = tPlayerY;
                }
            }

    }

}
