package golang

import (
	"fmt"
	"testing"
)

func Test_deserialize(t *testing.T) {
	tests := []string{
		"1,2,3,null,null,4,5",
		"1,2",
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			deserializer := Constructor()
			serializer := Constructor()
			deserialized := deserializer.deserialize(test)
			result := serializer.serialize(deserialized)

			if result != test {
				t.Errorf("Expected %v, got %v", test, result)
			}

		})
	}
}
