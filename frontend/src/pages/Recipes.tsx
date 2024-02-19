import {useEffect, useState} from "react";
import {Recipe} from "../shared/types/Recipe";


const Recipes = () => {
    const [recipes, setRecipes] = useState<Recipe[]>([]);

    useEffect(() => {
        fetch(
            '/recipes',
            {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                }
            }
        )
            .then((res) => {
                return res.json();
            })
            .then((data) => {
                console.log(data);
                setRecipes(data);
            });
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <div>

                    {recipes.map((recipe) => (
                        <>
                            <h1>{recipe.name}</h1>
                            <p>{recipe.description}</p>
                            {/*<ul>*/}
                            {/*    {recipe.ingredients.map((ingredient) => (*/}
                            {/*        <li key={ingredient.id}>{ingredient.name}</li>*/}
                            {/*    ))}*/}
                            {/*</ul>*/}
                        </>
                    ))}
                </div>
            </header>
        </div>
    );
}

export default Recipes;