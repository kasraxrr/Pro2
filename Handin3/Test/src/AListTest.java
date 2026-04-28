import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

class AListTest
{

    private AList<String> myAList;

    @BeforeEach
    void initialize()
    {
        myAList = new AList<>();
    }

    // ================= Zero Elements =================

    @Test
    void whenListIsNew_thenIsEmptyReturnsTrue()
    {
        assertTrue(myAList.isEmpty());
    }

    @Test
    void whenListIsNew_thenSizeIsZero()
    {
        assertEquals(0, myAList.size());
    }

    @Test
    void whenListIsEmpty_thenGetThrowsException()
    {
        assertThrows(IllegalStateException.class, () -> myAList.get(0));
    }

    @Test
    void whenListIsEmpty_thenRemoveByIndexThrowsException()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> myAList.remove(0));
    }

    // ================= One Element =================

    @Test
    void whenAddingOneItem_thenSizeIsOne()
    {
        myAList.add("Red");
        assertEquals(1, myAList.size());
    }

    @Test
    void whenAddingOneItem_thenGetReturnsThatItem()
    {
        myAList.add("Red");
        assertEquals("Red", myAList.get(0));
    }

    @Test
    void whenRemovingOnlyItem_thenReturnsItemAndListBecomesEmpty()
    {
        myAList.add("Red");
        String deletedItem = myAList.remove(0);

        assertEquals("Red", deletedItem);
        assertTrue(myAList.isEmpty());
    }

    // ================= Multiple Elements =================

    @Test
    void whenAddingMultipleItems_thenInsertionOrderIsKept()
    {
        myAList.add("Red");
        myAList.add("Green");
        myAList.add("Blue");

        assertEquals("Red", myAList.get(0));
        assertEquals("Green", myAList.get(1));
        assertEquals("Blue", myAList.get(2));
    }

    @Test
    void whenAddingAtIndex_thenElementIsInsertedCorrectly()
    {
        myAList.add("Red");
        myAList.add("Blue");

        myAList.add(1, "Green");

        assertEquals("Green", myAList.get(1));
    }

    @Test
    void whenRemovingMiddleItem_thenSubsequentItemsShiftLeft()
    {
        myAList.add("Red");
        myAList.add("Green");
        myAList.add("Blue");

        myAList.remove(1);

        assertEquals("Blue", myAList.get(1));
    }

    // ================= Boundaries & Capacity =================

    @Test
    void whenAddingAtZeroIndex_thenItemIsAtFront()
    {
        myAList.add("Green");
        myAList.add(0, "Red");

        assertEquals("Red", myAList.get(0));
    }

    @Test
    void whenAddingAtEndIndex_thenItemIsAtBack()
    {
        myAList.add("Red");
        myAList.add(1, "Green");

        assertEquals("Green", myAList.get(1));
    }

    @Test
    void whenAddingBeyondDefaultCapacity_thenListResizesSuccessfully()
    {
        for (int i = 0; i < 17; i++)
        {
            myAList.add("Color" + i);
        }

        assertEquals(17, myAList.size());
    }

    @Test
    void whenSettingValidIndex_thenElementIsReplaced()
    {
        myAList.add("Red");
        myAList.set(0, "Green");

        assertEquals("Green", myAList.get(0));
    }

    // ================= Invalid Inputs =================

    @Test
    void whenAddingAtInvalidIndex_thenThrowsException()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> myAList.add(1, "Red"));
    }

    @Test
    void whenSettingInvalidIndex_thenThrowsException()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> myAList.set(0, "Red"));
    }

    @Test
    void whenRemovingInvalidIndex_thenThrowsException()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> myAList.remove(0));
    }

    // ================= Object Exceptions =================

    @Test
    void whenRemovingNonExistentElement_thenThrowsException()
    {
        myAList.add("Red");

        assertThrows(IllegalStateException.class, () -> myAList.remove("Green"));
    }

    // ================= Null Handling =================

    @Test
    void whenAddingNull_thenNullIsAccepted()
    {
        myAList.add(null);
        assertEquals(1, myAList.size());
    }

    @Test
    void whenGettingNullElement_thenReturnsNull()
    {
        myAList.add(null);
        assertNull(myAList.get(0));
    }

    @Test
    void whenCallingIndexOfNull_thenReturnsCorrectIndex()
    {
        myAList.add(null);
        assertEquals(0, myAList.indexOf(null));
    }

    @Test
    void whenCheckingContainsNull_thenReturnsTrue()
    {
        myAList.add(null);
        assertTrue(myAList.contains(null));
    }

    @Test
    void whenRemovingNull_thenRemovesSuccessfully()
    {
        myAList.add(null);
        myAList.add("Red");

        myAList.remove(null);

        assertFalse(myAList.contains(null));
    }

    // ================= Searching =================

    @Test
    void whenCallingIndexOfExistingItem_thenReturnsCorrectIndex()
    {
        myAList.add("Red");
        myAList.add("Green");

        assertEquals(1, myAList.indexOf("Green"));
    }

    @Test
    void whenCallingIndexOfMissingItem_thenReturnsNegativeOne()
    {
        assertEquals(-1, myAList.indexOf("Purple"));
    }

    @Test
    void whenCallingContainsOnExistingItem_thenReturnsTrue()
    {
        myAList.add("Red");
        assertTrue(myAList.contains("Red"));
    }

    @Test
    void whenCallingContainsOnMissingItem_thenReturnsFalse()
    {
        assertFalse(myAList.contains("Red"));
    }



}