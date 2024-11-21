package msjava2lesson.moveZeroes;

public class Solution {
    public int[] moveZeroes(int[] a_num) {

        int i_num_length = a_num.length;

        if(1 > i_num_length || 10000 < i_num_length )
        {
            // Constraints:
            // 1 <= nums.length <= 10^4
            // * -2^31 <= nums[i] <= 2^31 - 1
            throw new ArrayInvalidException("Array is out of Constraints.");
        }

        int i_value_to_move_to_rear = 0;
        int i_index = -1;
        int i_iterate_value;

        for (int i_num = 0; i_num < i_num_length; i_num++)
        {
            i_iterate_value = a_num[i_num];
            if(i_value_to_move_to_rear == i_iterate_value)
            {
                if(i_index == -1)
                    i_index = i_num;

            }
            else
            {
                   if(i_index == -1)
                       continue;

                   a_num[i_index] = a_num[i_num];
                   a_num[i_num] = i_value_to_move_to_rear;
                   i_index++;
            }

        }

        return a_num;
    }
}
