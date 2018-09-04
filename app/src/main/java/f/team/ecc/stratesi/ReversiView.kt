package f.team.ecc.stratesi

import android.content.Context
import android.view.View
import android.util.DisplayMetrics
import android.app.Activity
import android.graphics.*
import android.view.WindowManager
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.util.AttributeSet
import android.util.Log
import android.view.Display
import android.view.MotionEvent
import android.graphics.BitmapFactory
import android.graphics.Bitmap






class ReversiView:View {
    companion object {
        var viewWidth = 0

        /**
         * 選択した位置を保存する変数
         */
        var row = 0
        var col = 0
    }
    constructor(context:Context):super(context)
    constructor(context: Context,attrs: AttributeSet):super(context,attrs)
    constructor(context:Context,attrs:AttributeSet,defStyleAttr:Int):super(context,attrs,defStyleAttr)

    private val MOVE = intArrayOf(-11, -10, -9, -1, 1, 9, 10, 11)
    private val placeMap = IntArray(100)
    private val boardMap = IntArray(100)
    private val PLAYER = 1
    private val RIVAL = 2
    private val IMG_BLACK = BitmapFactory.decodeResource(resources, R.drawable.black)
    private val IMG_WHITE = BitmapFactory.decodeResource(resources, R.drawable.white)
    val IMG_BOARD = BitmapFactory.decodeResource(resources,R.drawable.riversi_board)
    val IMG_RBOARD = resizeBitmapToDisplaySize(IMG_BOARD)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initBoard()
        val paint = Paint()
        canvas.drawBitmap(IMG_RBOARD,0.toFloat(),0.toFloat(),paint)
        var i = 11
        while (i <= 88) {
            if (boardMap[i] === PLAYER) canvas.drawBitmap(IMG_BLACK, viewWidth/8*(i%10-1).toFloat(), viewWidth/8*(i/10-1).toFloat(), paint)
            if (boardMap[i] === RIVAL) canvas.drawBitmap(IMG_WHITE, viewWidth/8*(i%10-1).toFloat(), viewWidth/8*(i/10-1).toFloat(), paint)
            Log.d("boardMapInitCheck",boardMap[i].toString()+i)
            i++
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val sideLength = measuredWidth
        setMeasuredDimension(sideLength,sideLength)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        Log.d("x軸",event.x.toString())
        Log.d("y軸",event.y.toString())
        Log.d("viewWidth", viewWidth.toString())
        when(event.action){
            MotionEvent.ACTION_UP -> {
                row = (event.x/(viewWidth/8)).toInt()
                col = (event.y/(viewWidth/8)).toInt()
                Log.d("row",row.toString())
            }
        }

        return true
    }

    /**
     * board画像を端末幅にresize
     */
    fun resizeBitmapToDisplaySize(src: Bitmap): Bitmap {
        var src = src
        val srcWidth = src.width // 元画像のwidth
        val srcHeight = src.height // 元画像のheight

        // 画面サイズを取得する
        val matrix = Matrix()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val disp = wm.defaultDisplay
        val screenWidth = disp.width.toFloat()
        val screenHeight = disp.height.toFloat()

        val widthScale = screenWidth / srcWidth
        val heightScale = screenHeight / srcHeight
        if (widthScale > heightScale) {
            matrix.postScale(heightScale, heightScale)
        } else {
            matrix.postScale(widthScale, widthScale)
        }
        viewWidth = screenWidth.toInt()
        // リサイズ
        val dst = Bitmap.createBitmap(src, 0, 0, srcWidth, srcHeight, matrix, true)
        return dst
    }

    fun canPutStone(){
        for(i in 0..100){
            placeMap[i] = 0
            if(i in 1..99 && boardMap[i]==0){
                for(j in 0..7){
                    for(k in 0..7){

                    }
                }
            }
        }

    }

    fun initBoard(){
        var i = 0
        //ゲームの初期化
        while (i < 100) {
            boardMap[i] = 0
            i++
        }
        i = 0
        while (i < 10) {
            boardMap[i] = -1
            i++
        }
        i = 1
        while (i < 9) {
            boardMap[i * 10] = -1
            i++
        }
        i = 1
        while (i < 9) {
            boardMap[i * 10 + 9] = -1
            i++
        }
        i = 0
        while (i < 10) {
            boardMap[i + 90] = -1
            i++
        }
        boardMap[44] = RIVAL
        boardMap[45] = PLAYER
        boardMap[54] = PLAYER
        boardMap[55] = RIVAL
    }

    fun test(){
        Log.d("view内のメソッドを実行","できた")
    }
}