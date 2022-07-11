interface KoreaElectric { //내가 제공받는 220V 전기
    fun onSupply()
}
interface Fan { // 내가 원하는 동작
    fun onOperate()
}

class TwoTwoZeroFan : KoreaElectric { // 220V로 된 선풍기
    override fun onSupply() {
        println("선풍기 작동!!")
    }
}

class Adapter(var electric : KoreaElectric) : Fan { // 어댑터로 220V에서 110V로 감압
    override fun onOperate() {
        electric.onSupply()
    }
}

class User { // 주체 생성
    var adapter : Fan = Adapter(TwoTwoZeroFan())
    fun onStart(){
        adapter.onOperate()
    }
}

fun main(){
    var grandmother = User()
    grandmother.onStart()
}