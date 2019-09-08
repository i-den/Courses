function theElemelons() {
    class Melon {
        constructor(weight, melonSort) {
            if (new.target === Melon) {
                throw new Error("Cannot instantiate the Melon Class directly");
            }

            this.weight = weight;
            this.melonSort = melonSort;
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }

        toString() {
            let str = `Sort: ${this.melonSort}\n`;
            str += `Element Index: ${this.elementIndex}`;
            return str;
        }
    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Water";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Fire";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Earth";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Air";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        morph(){
            if(this.element === "Water"){
                this.element = "Fire";
            } else if (this.element === "Fire"){
                this.element = "Earth";
            } else if(this.element === "Earth"){
                this.element = "Air";
            } else {
                this.element = "Water";
            }
        }
    }

    return {
        Melon,
        Watermelon,
        Firemelon,
        Earthmelon,
        Airmelon,
        Melolemonmelon
    }
}