const spreadSheetContainer = document.querySelector('#spreadsheet-container');

const ROWS = 10;
const COLS = 10;

const spreadsheet = [];

class Cell {
    constructor(isHeader, disabled, data, row, column, active = false){
        this.isHeader = isHeader;
        this.disabled = disabled;
        this.data = data;
        this.row = row;
        this.column = column;
        this.active = active;
    }
}

//const cell1 = new Cell(true, true, '', 0, 0);

initSpreadsheet();

function initSpreadsheet(){
    for( let i = 0; i < ROWS; i++){
        let spreadsheetRow = [];
        for(let j = 0; j < COLS; j++){
            const cell = new Cell(false, false, i + "-" + j, i, j, false);
            spreadsheetRow.push(cell);
        }
        spreadsheet.push(spreadsheetRow);
    }
    console.log(spreadsheet);
}


function createCellEl(cell){
    const cellEl = document.createElement('input');
    cellEl.className = 'cell';
    cellEl.id = 'cell_' + cell.row + cell.column;
    cellEl.value = cell.data;
    cellEl.disabled = cell.disabled;

    return cellEl;
}


function drawSheet(){
    for( let i = 0; i < spreadsheet.length; i++){
        
        for(let j = 0; j < spreadsheet[i].length; j++){
            const cell = spreadsheet[i][j];
            const cellEl = createCellEl(cell);
            spreadSheetContainer.appendChild(cellEl);
        }
    }
}

