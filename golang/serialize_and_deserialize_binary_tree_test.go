package golang

import "testing"

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */

func Test_deserialize(t *testing.T) {
	data := "[1,2,3,null,null,4,5]"
	deserializer := Constructor()
	serializer := Constructor()
	result := serializer.serialize(deserializer.deserialize(data))

	if data != result {
		t.Error()
	}
}
