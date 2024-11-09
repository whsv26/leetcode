package golang_problems

import (
	"fmt"
	"testing"
)

func Test_isPalindrome(t *testing.T) {
	tests := []struct {
		Num      int
		Expected bool
	}{
		{121, true},
		{1352531, true},
		{135531, true},
		{-121, false},
		{10, false},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := isPalindrome(test.Num)
			if actual != test.Expected {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}
