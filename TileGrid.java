
/**
 * A grid created by an array of Tiles that represents the board space
 *
 * @Team MAGA
 * @Author Gajun Young - 16440714
 * @Author Royal Thomas - 16326926
 * @Author Richard  Otroshchenko - 16353416
 */


public class TileGrid {
	public Tile[][] map; //Array of Tiles

	//{WALL, PATH, ROOM, ENTERANCE, SECRET, SIT};
	private int[][] property = new int[][]
				  { {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
					{2,2,2,2,2,4,0,1,1,1,2,2,2,2,1,1,1,0,2,2,6,2,6,2},
					{2,6,2,6,2,2,1,1,2,2,6,6,6,2,2,2,1,1,2,6,5,5,5,2},
					{2,5,5,5,6,2,1,1,2,2,6,6,6,2,2,2,1,1,2,6,5,5,5,2},
					{2,5,5,5,6,2,1,1,2,2,5,5,5,2,2,2,1,7,3,2,6,2,6,2},
					{2,6,2,6,2,2,1,1,3,2,5,5,5,2,2,3,1,1,1,2,2,2,4,0},
					{0,2,2,2,3,2,1,1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,2,3,2,2,2,2,3,2,1,1,1,1,1,1,1,0},
					{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2},
					{2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,3,2,6,6,5,5},
					{2,2,2,2,2,2,2,2,1,1,0,0,0,0,0,1,1,1,2,2,6,6,5,5},
					{6,6,5,5,2,2,2,2,1,1,0,0,0,0,0,1,1,1,2,2,6,6,5,5},
					{6,6,5,5,2,2,2,3,1,1,0,0,0,0,0,1,1,1,2,2,2,2,3,2},
					{6,6,5,5,2,2,2,2,1,1,0,0,5,0,0,1,1,1,1,1,1,1,1,0},
					{2,2,2,2,2,2,2,2,1,1,0,0,0,0,0,1,1,1,2,2,3,2,2,0},
					{2,2,2,2,2,2,3,2,1,1,0,0,0,0,0,1,1,2,6,6,2,5,5,2},
					{0,1,1,1,1,1,1,1,1,1,0,0,3,0,0,1,1,3,6,6,2,5,5,2},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6,6,2,5,5,2},
					{0,1,1,1,1,1,1,1,1,2,2,3,3,2,2,1,1,1,2,2,2,2,2,0},
					{4,2,2,2,2,2,3,7,1,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1},
					{2,2,2,2,2,2,2,1,1,2,6,5,5,6,3,1,1,1,1,1,1,1,1,0},
					{2,2,5,5,5,2,2,1,1,2,2,5,5,2,2,1,7,3,2,2,2,2,2,4},
					{2,2,5,5,5,2,2,1,1,2,6,5,5,6,2,1,1,2,2,5,5,5,6,2},
					{2,6,6,6,2,2,2,1,1,2,2,6,6,2,2,1,1,2,2,5,5,5,6,2},
					{2,6,6,6,2,2,0,1,0,2,2,2,2,2,2,0,1,0,2,6,6,6,6,2}
			};

	//{NO_ROOM,KITCHEN,BALLROOM,CONSERVATORY,DINING,BILLIARD,LIBRARY, LOUNGE, HALL, STUDY}
	private int[][] room = new int[][]
				  { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,0,0,0,0,2,2,2,2,0,0,0,0,3,3,3,3,3,3},
					{1,1,1,1,1,1,0,0,2,2,2,2,2,2,2,2,0,0,3,3,3,3,3,3},
					{1,1,1,1,1,1,0,0,2,2,2,2,2,2,2,2,0,0,3,3,3,3,3,3},
					{1,1,1,1,1,1,0,0,2,2,2,2,2,2,2,2,0,0,3,3,3,3,3,3},
					{1,1,1,1,1,1,0,0,2,2,2,2,2,2,2,2,0,0,0,3,3,3,3,0},
					{0,1,1,1,1,1,0,0,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5},
					{4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5},
					{4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5},
					{4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5},
					{4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5},
					{4,4,4,4,4,4,4,4,0,0,10,10,10,10,10,0,0,0,0,0,0,0,0,0},
					{4,4,4,4,4,4,4,4,0,0,10,10,10,10,10,0,0,0,6,6,6,6,6,0},
					{4,4,4,4,4,4,4,4,0,0,10,10,10,10,10,0,0,6,6,6,6,6,6,6},
					{0,0,0,0,0,0,0,0,0,0,10,10,10,10,10,0,0,6,6,6,6,6,6,6},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,6,6,6,6,6},
					{0,0,0,0,0,0,0,0,0,8,8,8,8,8,8,0,0,0,6,6,6,6,6,0},
					{7,7,7,7,7,7,7,0,0,8,8,8,8,8,8,0,0,0,0,0,0,0,0,0},
					{7,7,7,7,7,7,7,0,0,8,8,8,8,8,8,0,0,0,0,0,0,0,0,0},
					{7,7,7,7,7,7,7,0,0,8,8,8,8,8,8,0,0,9,9,9,9,9,9,9},
					{7,7,7,7,7,7,7,0,0,8,8,8,8,8,8,0,0,9,9,9,9,9,9,9},
					{7,7,7,7,7,7,7,0,0,8,8,8,8,8,8,0,0,9,9,9,9,9,9,9},
					{7,7,7,7,7,7,0,0,0,8,8,8,8,8,8,0,0,0,9,9,9,9,9,9}
			};


	//Array size
	private static final int COLUMN = 24;
	private static final int ROW = 25;

	//Grid offset
	private float x = 42.5f;
	private float y;

	//Constructor that builds the array of tiles
	public TileGrid() {
		map = new Tile[ROW][COLUMN];  //Dimension of the Board
		for (int i = 0; i < map.length; i++) {
			y += 23;
			x = 42.5f;
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(x, y, i, j, property[i][j], room[i][j]);
				x += 23;
			}
		}
	}
	/*
	//Draw the grid tiles onto the map
	public void drawGrid(Graphics g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].drawTile(g);
			}
		}
	}*/
}
