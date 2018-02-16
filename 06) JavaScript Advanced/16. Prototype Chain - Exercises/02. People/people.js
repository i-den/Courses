function solve() {

    class Employee {
        constructor(name, age) {
            if (new.target === Employee) {
                throw new TypeError("Cannot Instantiate an Abstract Employee Class")
            }
            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = [];
        }

        work() {
            console.log(`${this.name} ` + this.tasks[0]);
            this.tasks = this.tasks.slice(1).concat(this.tasks[0]);
        }

        collectSalaray() {
            console.log(`${this.name} received ${this.getSalary()} this month.`)
        }

        getSalary() {
            return this.salary;
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age);
            this.tasks.push("is working on a simple task.");
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age);
            [
                "is working on a complicated task.",
                "is taking time off work.",
                "is is supervising junior workers"
            ].forEach(e => this.tasks.push(e));
        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age);
            this.divident = 0;
            [
                "scheduled a meeting.",
                "is preparing a quarterly report."
            ].forEach(e => this.tasks.push(e));
        }

        getSalary() {
            return super.getSalary() + this.divident;
        }
    }

    return {
        Employee,
        Junior,
        Senior,
        Manager
    }
}