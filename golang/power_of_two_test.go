package golang

import (
	"fmt"
	"testing"
)

func Test_isPowerOfTwo(t *testing.T) {
	tests := []struct {
		Num      int
		Expected bool
	}{
		{0, false},
		{1, true},
		{2, true},
		{4, true},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := []bool{
				isPowerOfTwo(test.Num),
			}

			for _, actual := range results {
				if actual != test.Expected {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
