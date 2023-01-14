import {createSlice} from "@reduxjs/toolkit";

export const pointSlice = createSlice({
    name: 'point',
    initialState: {
        count: 0,
        points: []
    },
    reducers: {
        setCount: (state, action) => {
            state.count = action.payload;
        },
        addPoint: (state, action) => {
            state.points.push(action.payload);
        },
        clearAll: (state) => {
            state.count = 0;
            state.points = [];
        },
    }
})

export const {setCount, addPoint, clearAll} = pointSlice.actions;

const pointReducer = pointSlice.reducer;

export default pointReducer;