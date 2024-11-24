package msjava2lesson.moveZeroes;

public class Solution {
    public int[] moveZeroes(int[] aNum) {

        int iNumLength = aNum.length;

        if(1 > iNumLength || 10000 < iNumLength ) {
            // Constraints:
            // 1 <= nums.length <= 10^4
            // * -2^31 <= nums[i] <= 2^31 - 1
            throw new ArrayInvalidException("Array is out of Constraints.");
        }

        int iValueToMoveToRear = 0; // Here may be any value, the zero value is just the task condition.
        int iEarliestValueIndexToMove = -1; // Index of value to move to rear of array.
        int iIterateValue; // Current value in the cycle iteration.

        for (int iNum = 0; iNum < iNumLength; iNum++) {
            iIterateValue = aNum[iNum];
            if(iValueToMoveToRear == iIterateValue) {
                if(iEarliestValueIndexToMove == -1) {
                    iEarliestValueIndexToMove = iNum;
                }
            }
            else {
                if(iEarliestValueIndexToMove == -1) {
                    // case when array starts not from the iValueToMoveToRear value.
                    continue;
                }

                aNum[iEarliestValueIndexToMove] = aNum[iNum];
                aNum[iNum] = iValueToMoveToRear;
                iEarliestValueIndexToMove++;
            }
        }

        return aNum;
    }
}
