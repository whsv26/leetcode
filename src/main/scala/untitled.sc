val num = Integer.parseUnsignedInt("1010101010101010101010101010101", 2)

val r1 = num.toBinaryString
val r2 = (num & ~(1 << 31)).toBinaryString
//val r3 =  (num | ((num & (1 << 5)) >> 5)).toBinaryString
val r4 = ((num & (1 << 0)) << 31).toBinaryString
val r5 = ((num & (1 << 0)) >> 28).toBinaryString