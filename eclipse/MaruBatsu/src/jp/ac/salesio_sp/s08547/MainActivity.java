package jp.ac.salesio_sp.s08547;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{
	
	int[][] marubatsu = new int[3][3];
	int turn = 0;
	boolean turnFlag = true;
	boolean[] judgeFlag = new boolean[8];
	boolean[] bot = new boolean[9];
	
	TextView textView;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)this.findViewById(R.id.textView1);
        button1 = (Button)this.findViewById(R.id.button1);
        button2 = (Button)this.findViewById(R.id.button2);
        button3 = (Button)this.findViewById(R.id.button3);
        button4 = (Button)this.findViewById(R.id.button4);
        button5 = (Button)this.findViewById(R.id.button5);
        button6 = (Button)this.findViewById(R.id.button6);
        button7 = (Button)this.findViewById(R.id.button7);
        button8 = (Button)this.findViewById(R.id.button8);
        button9 = (Button)this.findViewById(R.id.button9);
        
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        
        for(int i=0; i<judgeFlag.length; i++)judgeFlag[i] = false;
        for(int i=0; i<bot.length; i++)bot[i] = true;
        showTurnString(turnFlag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		if(v == button1 && bot[0]){
			bot[0] = !bot[0];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[0][0] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[0][0] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button2 && bot[1]){
			bot[1] = !bot[1];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[0][1] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[0][1] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button3 && bot[2]){
			bot[2] = !bot[2];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[0][2] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[0][2] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button4 && bot[3]){
			bot[3] = !bot[3];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[1][0] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[1][0] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button5 && bot[4]){
			bot[4] = !bot[4];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[1][1] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[1][1] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button6 && bot[5]){
			bot[5] = !bot[5];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[1][2] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[1][2] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button7 && bot[6]){
			bot[6] = !bot[6];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[2][0] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[2][0] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button8 && bot[7]){
			bot[7] = !bot[7];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[2][1] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[2][1] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		if(v == button9 && bot[8]){
			bot[8] = !bot[8];
			if(turnFlag){
				((Button) v).setText("○");
				marubatsu[2][2] = 1;
			}else{
				((Button) v).setText("×");
				marubatsu[2][2] = 2;
			}
			turn++;
			judge(turnFlag);
			turnFlag = !turnFlag;
			showTurnString(turnFlag);
		}
		
	}
	
	private String showTurnString(boolean flag){
		if(flag){
			return "○のターンです";
		}else{
			return "×のターンです";
		}
	}
	
	private void judge(boolean flag){
		String play = new String();
		judgeFlag[0] = marubatsu[0][0] == marubatsu[0][1] && marubatsu[0][1] == marubatsu[0][2] && marubatsu[0][0] != 0;//yoko1
		judgeFlag[1] = marubatsu[1][0] == marubatsu[1][1] && marubatsu[1][1] == marubatsu[1][2] && marubatsu[1][0] != 0;//yoko2
		judgeFlag[2] = marubatsu[2][0] == marubatsu[2][1] && marubatsu[2][1] == marubatsu[2][2] && marubatsu[2][0] != 0;//yoko3
		judgeFlag[3] = marubatsu[0][0] == marubatsu[1][0] && marubatsu[1][0] == marubatsu[2][0] && marubatsu[0][0] != 0;//tate1
		judgeFlag[4] = marubatsu[0][1] == marubatsu[1][1] && marubatsu[1][1] == marubatsu[2][1] && marubatsu[0][1] != 0;//tate2
		judgeFlag[5] = marubatsu[0][2] == marubatsu[1][2] && marubatsu[1][2] == marubatsu[2][2] && marubatsu[0][2] != 0;//tate3
		judgeFlag[6] = marubatsu[0][0] == marubatsu[1][1] && marubatsu[1][1] == marubatsu[2][2] && marubatsu[0][0] != 0;//naname1
		judgeFlag[7] = marubatsu[2][0] == marubatsu[1][1] && marubatsu[1][1] == marubatsu[0][2] && marubatsu[2][0] != 0;//naname2
		
		for(int i=0; i<judgeFlag.length; i++){
			if(judgeFlag[i]){
				if(flag)
					play = "○の勝ち";
				else
					play = "×の勝ち";
				Toast.makeText(this, play, Toast.LENGTH_LONG).show();
				for(int j=0; j<bot.length; j++)bot[j] = false;
				turn = 10;
				break;
			}
		}
		if(turn == 9){
			Toast.makeText(this, "ドロー", Toast.LENGTH_LONG).show();
		}
	}
}
