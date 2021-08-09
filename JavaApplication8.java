package javaapplication8;

/**
 *
 * @author Josberto
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        int[][] matriz = {{10,33,13,15},{22,21,4,1},{5,0,2,3},{0,6,14,2}};
        System.out.println(way(matriz));
    }
    
    /**
     * way - Processa a matriz em busca da maior somatória para caminho percorrido na matriz
     * @param matriz
     * @return 
     */
    public static int way(int[][] matriz){
        
        int _x = 0;int _y = 0;int pos = 0; int maxBananas = 0;
        
        for(int w = 0; w < matriz.length; w++){            
            int count = 0;
            for(int h = 0; h < matriz.length; h++){                
                if(_x == 0 && _y == 0 ){
                    count += matriz[_x][_y];
                    pos = posInicioTop( matriz[_x][_y+1], matriz[_x+1][_y+1] );                    
                    if(pos == 2){
                       _x += 1; 
                       _y +=1;  
                    } else if(pos == 0){
                       _y +=1;  
                    }
                    count += matriz[_x][_y];                    
                }else if((_x == 0) && _y < matriz[_x].length-1){
                    pos = posInicioTop( matriz[_x][_y+1], matriz[_x+1][_y+1] );                    
                    if(pos == 2){
                       _x += 1; 
                       _y +=1;  
                    } else if(pos == 0){
                       _y +=1;  
                    }
                    count += matriz[_x][_y];                    
                }
                if(_x > 0 && _x != matriz.length - 1){
                    if(_y == 0){
                        count += matriz[_x][_y];
                    }                    
                    if(_y < matriz[_x].length-1){                        
                        pos = posIntermediarias( matriz[_x-1][_y+1], matriz[_x][_y+1], matriz[_x+1][_y+1]);
                        if(pos == 0){                            
                            _y+=1;
                        }else if(pos == 1){
                            _x-=1; _y+=1;
                        }else if(pos == 2){
                            _x+=1; _y+=1;
                        }                        
                        count += matriz[_x][_y];
                    }                
                    
                } if (_x > 0 && _x == matriz.length - 1){                    
                    if(  _y < matriz[_x].length - 1 ){
                        pos = posInicioBottom( matriz[_x-1][_y+1], matriz[_x][_y+1]);
                        if(pos == 0){
                            _y+=1;
                        }else if(pos == 1){
                            _x -= 1; _y+=1;
                        }                        
                    }
                }
            }
            _x = 1 + w;
            _y = 0;
            if(maxBananas < count){
                maxBananas = count;
            }
        }
        return maxBananas;
    }
    
    /**
     * Identica qual a direção o código deve seguir quando a leitura esta na primieria linha da matriz
     * @param x
     * @param y
     * @return 
     */
    private static int posInicioTop(int x, int y){
        int retorno = 0;
        if (x == y){
            retorno = 0;
        }else if( x < y){
            retorno = 2;
        }else if( x > y){
            retorno = 0;
        }
        return retorno;
    }
    
    /**
     * Inidica qual a direção o código deve seguira quando a interação estão na última linha da matriz
     * @param x
     * @param y
     * @return 
     */
    private static int posInicioBottom(int x, int y){
     int retorno = 0;
        if (x == y){            
            retorno = 0;
        }else if( x < y){            
            retorno = 0;
        }else if( x > y){            
            retorno = 1;
        }
        return retorno;
    }
    
    /**
     * Indica a direção que o código deve seguir quando a leitura estiver em uma linha interna da matriz
     * @param x
     * @param y
     * @param z
     * @return 
     */
    private static int posIntermediarias(int x, int y, int z){
        int retorno = 0;
        if(x == y && x == z){            
            retorno = 0;
        }else if(x == y && y > z){            
            retorno = 0;
        } else if(x == y && z > y){            
            retorno = 2;
        } else if( x == y && x > z){            
            retorno = 0;
        } else if(x == z && y > z){            
            retorno = 0;
        } else if(x == z && z > y){            
            retorno = 2;
        } else if(y == z && x > y){            
            retorno = 1;
        } else if(y == z && x < y){            
            retorno = 0;
        } else if(z > x && z > y){            
            retorno = 2;
        } else if( y > x && y > z){            
            retorno = 0;
        }else if( x > y && x > z){            
            retorno = 1;
        }
        return retorno;
    }
}
